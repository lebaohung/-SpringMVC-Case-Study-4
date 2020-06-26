package com.codegym.cms;

import com.codegym.cms.formatter.admin.AccountFormatter;
import com.codegym.cms.formatter.admin.ProvinceFormatter;
import com.codegym.cms.formatter.admin.StatusFormatter;
import com.codegym.cms.service.admin.*;
import com.codegym.cms.service.admin.impl.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Locale;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("com.codegym.cms.controller")
@EnableJpaRepositories("com.codegym.cms.repository") //com.codegym.cms.formatter + repo
@EnableSpringDataWebSupport //Phantrang
@EnableAspectJAutoProxy  //AOP
@EnableTransactionManagement
@PropertySource("classpath:uploadfile.properties") //uploadfile
//
public class AppConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {


    @Bean
    public IfUserService iUserService() {
        return new UserServiceImpl();
    }

    @Bean
    public IfOrderService iBillService() {
        return new OrderServiceImpl();
    }

    @Bean
    public IfProvinceService iProvinceService() {
        return new ProvinceServiceImpl();
    }

    @Bean
    public IfStatusService iStatusService() {
        return new StatusServiceImpl();
    }

    @Bean
    public IfAccountService iAccountService() {
        return new AccountServiceImpl();
    }


    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    public TemplateEngine templateEngine() {
        TemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.addDialect( new SpringSecurityDialect()); //form security log in
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setContentType("text/html;charset=utf-8");
        return viewResolver;
    }

    //JPA
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/caseStudy4?characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    @Qualifier(value = "entityManager")  //not know
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"com.codegym.cms.model.admin"});
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("message", "ValidationMessage");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    //Config FileUpload
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        //Set the maximum allowed size (in bytes) for each individual file.
        resolver.setMaxUploadSizePerFile(5242880);//5MB
        //You may also set other available properties.
        return resolver;
    }

    // Cấu hình để sử dụng các file nguồn tĩnh (css, image, js..)
    @Autowired
    Environment env;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String fileUpload = env.getProperty("file_upload").toString();
        // Image resource.
        registry.addResourceHandler
                ("/", "/#/","/resources/admin/**","/resources/admin/", "/img/**", "/resources/**", "resources/img/**", "/i/", "/img/", "/static/**")
                .addResourceLocations
                        ("file:" + fileUpload, "/static/", "/resources", "resources/", "/resources/","/resources/admin/**","/resources/admin/");

    }

    //i18n
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("vn"));
        return localeResolver;
    }

    //i18n
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }

    //formater
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(
                new ProvinceFormatter(
                        applicationContext.getBean(IfProvinceService.class))
        );
        registry.addFormatter(
                new StatusFormatter(
                        applicationContext.getBean(IfStatusService.class)
                )
        );
        registry.addFormatter(
                new AccountFormatter(
                        applicationContext.getBean(IfAccountService.class)
                )
        );
    }
}
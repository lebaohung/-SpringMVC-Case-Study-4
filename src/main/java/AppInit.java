//package manageCustomer.Province.config;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;


//lớp khởi tạo ứng dụng
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
//        return new Class[]{AppConfiguration.class,WebSecurityConfig.class};
//        return new Class[]{WebSecurityConfig.class}; //tao bộ lọc securityfilterchain
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{};
//        return new Class[0];
//        return new Class[]{AppConfiguration.class};  //Cấu hình spring web
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return new Filter[]{filter};
    }
}

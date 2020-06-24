package formatter.admin;

import model.admin.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import service.admin.IProvinceService;

import java.text.ParseException;
import java.util.Locale;

public class ProvinceFormatter implements Formatter<Province> {
    @Autowired
    private IProvinceService iProvinceService;

    @Autowired
    public ProvinceFormatter(IProvinceService iProvinceService) {
        this.iProvinceService = iProvinceService;
    }

    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        return iProvinceService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Province object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }

}

package formatter.admin;

import model.admin.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import service.admin.IStatusService;

import java.text.ParseException;
import java.util.Locale;

public class StatusFormatter implements Formatter<Status> {
    @Autowired
    private IStatusService iStatusService;

    @Autowired
    public StatusFormatter(IStatusService iStatusService) {
        this.iStatusService=iStatusService;
    }

    @Override
    public Status parse(String text, Locale locale) throws ParseException {
        return iStatusService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Status object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }

}

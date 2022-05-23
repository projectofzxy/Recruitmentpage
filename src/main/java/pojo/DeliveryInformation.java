package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryInformation {
    private int id;
    private String companyname;
    private String hirername;
    private String resume;
    private Date date;
    public String getDate() {

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateformat.format(date);
    }
}

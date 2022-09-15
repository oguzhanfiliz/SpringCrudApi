package demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
public class DateRequest {
        private Date start_date;
        private Date end_date;
}

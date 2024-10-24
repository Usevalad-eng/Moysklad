package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UserSettingsWithLombok {

    protected String name;
    protected String patronymic;
    protected String lastname;
    protected String phone;
    protected String position;
    //protected String customer; //must work
    //protected int customer;
}

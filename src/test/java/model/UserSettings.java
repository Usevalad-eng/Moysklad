package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UserSettings {

    private String name;
    private String patronymic;
    private String lastname;
    private String phone;
    private String position;
    private String customer;
}

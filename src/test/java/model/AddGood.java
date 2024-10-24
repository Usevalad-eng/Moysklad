package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class AddGood {

    //private String description;
    private String article;
    private String code;

}

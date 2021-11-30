package com.example.SwaggerDemo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@ApiModel(description = "Deatils of contact")
public class Contact {

  @ApiModelProperty(notes = "unique id of contact")
  private String id;

  @ApiModelProperty(notes = "name of contact")
  private String name;

  @ApiModelProperty(notes = "phone number of contact")
  private String phone;

}

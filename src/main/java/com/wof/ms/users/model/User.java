package com.wof.ms.users.model;

import com.wof.ms.users.model.interfaces.IDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User implements IDTO {

  @Id
  private Integer id;
  private String name;
  private String lastName;
  private String email;
  private String rol;
  private List<String> pets;

}

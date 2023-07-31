package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/*
    "result": {
        "id": "1",
        "username": "biloute",
        "password": "$2y$10$dRs6pPoBu935RpmsrhmbjevJH5MgZ7Kr9QrnVINwwyZ3.MOwqg.0m",
        "role": "app-user",
        "is_ldap_user": "0",
        "name": "",
        "email": "",
        "google_id": null,
        "github_id": null,
        "notifications_enabled": "0"
    }
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserByIdRespResult {
  Long id;
  String username;
  String password;
  String role;
  String is_ldap_user;
  String name;
  String email;
  String google_id;
  String github_id;
  String notifications_enabled;
}

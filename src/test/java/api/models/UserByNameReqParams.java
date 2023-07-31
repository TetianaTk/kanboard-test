package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/*
{
    "jsonrpc": "2.0",
    "method": "getUserByName",
    "id": 1769674782,
    "params": {
        "username": "biloute"
    }
}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserByNameReqParams {
  String username;
}

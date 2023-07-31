package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/*
{
    "jsonrpc": "2.0",
    "method": "createUser",
    "id": 1518863034,
    "params": {
        "username": "biloute",
        "password": "123456"
    }
}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CreateUserReq extends BasicReq<CreateUserReqParams> {
  CreateUserReqParams params;
}

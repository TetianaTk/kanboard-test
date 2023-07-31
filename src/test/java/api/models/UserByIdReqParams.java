package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
/*
{
    "jsonrpc": "2.0",
    "method": "some_method",
    "id": 1769674781,
    "params": {
        "user_id": 1
    }
}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserByIdReqParams {
  Integer user_id;
}


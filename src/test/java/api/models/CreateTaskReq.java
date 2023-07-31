package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/*
{
    "jsonrpc": "2.0",
    "method": "createTask",
    "id": 1176509098,
    "params": {
        "title": "Test",
        "project_id": 1,
        "owner_id": 1,
        "creator_id": 0,
    }
}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CreateTaskReq extends BasicReq<CreateTaskReqParams> {
  CreateTaskReqParams params;
}

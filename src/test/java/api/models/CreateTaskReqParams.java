package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/*
{
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
public class CreateTaskReqParams {
  String title;
  Integer project_id;
  Integer owner_id;
  Integer creator_id;
}

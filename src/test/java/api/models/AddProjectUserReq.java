package api.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
/*
{
    "jsonrpc": "2.0",
    "method": "addProjectUser",
    "id": 1294688355,
    "params": [
        "1",
        "1",
        "project-viewer"
    ]
}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AddProjectUserReq extends BasicReq<List<String>> {
  List<String> params;
}

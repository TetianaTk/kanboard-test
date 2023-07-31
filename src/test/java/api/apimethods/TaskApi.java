package api.apimethods;

import api.models.CommonResp;
import api.models.CreateTaskReq;
import api.models.CreateTaskReqParams;
import api.models.TaskByIdReq;
import api.models.TaskByIdReqParams;
import io.qameta.allure.Step;

public class TaskApi extends BasicApi {

  @Step("API create task")
  public static CommonResp createTask(String username, String password, String title, Integer projectId, Integer ownerId, Integer creatorId) {
    CreateTaskReq taskReq = requestBodyObject(CreateTaskReq.class, "createTask", 1176509098L,
        new CreateTaskReqParams().builder().title(title).project_id(projectId).owner_id(ownerId)
            .creator_id(creatorId).build());
    return respondClassObject(username, password, taskReq, CommonResp.class);
  }

  @Step("API remove task")
  public static CommonResp removeTask(String username, String password, Integer taskId){
    TaskByIdReq task = requestBodyObject(TaskByIdReq.class, "removeTask", 1423501287L,
        new TaskByIdReqParams(taskId));
    return respondClassObject(username, password, task, CommonResp.class);
  }


}

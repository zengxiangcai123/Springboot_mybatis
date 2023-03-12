package zxc.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQuery {
    private Integer pageNum = 1;   //当前页数
    private Integer pageSize = 8;  //每一页显示的数量
    private String name;  // 跟进用户查询

}

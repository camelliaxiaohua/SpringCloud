package users.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import users.pojo.User;

public interface UserMapper {
    
    @Select("select * from tb_user where id = #{id}")
    User findById(@Param("id") Long id);
}
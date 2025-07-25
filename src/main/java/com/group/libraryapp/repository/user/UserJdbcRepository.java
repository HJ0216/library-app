package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.response.UserResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserJdbcRepository {

  private JdbcTemplate jdbcTemplate;

//  public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
//    this.jdbcTemplate = jdbcTemplate;
//  }

  public void saveUser(String name, int age) {
    String sql = "insert into user (name, age) values (?, ?)";
    jdbcTemplate.update(sql, name, age); // insert, update, delete 모두 가능
  }

  public List<UserResponse> getUsers() {
    String sql = "select * from user";
    return jdbcTemplate.query(sql, (rs, rowNum) -> {
      long id = rs.getLong("id");
      String name = rs.getString("name");
      int age = rs.getInt("age");
      return new UserResponse(id, name, age);
    });
  }

  public boolean isUserNotExits(long id) {
    String readSql = "select * from user where id = ?";
    return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, id).isEmpty();
  }

  public void updateUserName(String name, long id) {
    String sql = "update user set name = ? where id = ?";
    jdbcTemplate.update(sql, name, id);
  }

  public boolean isUserNotExits(String name) { // overload
    String readSql = "select * from user where name = ?";
    return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
  }

  public void deleteUser(String name){
    String sql = "delete from user where name = ?";
    jdbcTemplate.update(sql, name);
  }

}

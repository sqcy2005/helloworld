package org.lxh.useradmin.dao.impl;

import com.google.inject.Inject;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.RecordMapper;
import org.jooq.impl.DSL;
import org.lxh.useradmin.bo.User;
import org.lxh.useradmin.dao.IUserDAO;
import org.lxh.useradmin.entity.tables.records.UserRecord;

import java.util.Date;
import java.util.List;

import static org.lxh.useradmin.entity.tables.User.USER;

/**
 * Created by songqian on 16/9/24.
 */
public class IUserDAOImpl implements IUserDAO {

  //  private DSLContext jooq;
//
//  @Inject
//  public IUserDAOImpl(DSLContext jooq) {
//    this.jooq = jooq;
//  }
//
//  //将userRecord结果转换成vo
//  private RecordMapper<UserRecord, User> userRecordMapper = userRecord -> {
//    User user = null;
//    if (userRecord != null) {
//      user = new User();
//      user.setId(userRecord.getId());
//      user.setName(userRecord.getName());
//      user.setSex(userRecord.getSex());
//      user.setDepart_id(userRecord.getDepartId());
//      user.setBirthday(new Date(userRecord.getBirthday().getTime()));
//    }
//    return user;
//  };
  private DSLContext jooq;


  RecordMapper<UserRecord, User> recordUserRecordMapper = new RecordMapper<UserRecord, User>() {

    @Override
    public User map(UserRecord userRecord) {
      return null;
    }
  };

  @Inject
  public IUserDAOImpl(DSLContext jooq) {
    this.jooq = jooq;
  }




  private RecordMapper<UserRecord, User> userRecordMapper = userRecord -> {
    User user = null;
    if (userRecord != null) {
      user = new User();
      user.setId(userRecord.getId());
      user.setName(userRecord.getName());
      user.setSex(userRecord.getSex());
      user.setDepart_id(userRecord.getDepartId());
      user.setBirthday(new Date(userRecord.getBirthday().getTime()));

    }
    return user;
  };

//
//  public boolean doCreate(User user) throws Exception {
//    int effectRow = jooq.insertInto(USER)
//      .set(USER.NAME, user.getName())
//      .set(USER.SEX, user.getSex())
//      .set(USER.DEPART_ID, user.getDepart_id())
//      .set(USER.BIRTHDAY, new java.sql.Date(user.getBirthday().getTime()))
//      .execute();
//    return effectRow > 0;
//  }

  public boolean doCreate(User user, Configuration configuration) throws Exception {
    int effectRow = DSL.using(configuration).insertInto(USER)
      .set(USER.NAME, user.getName())
      .set(USER.SEX, user.getSex())
      .set(USER.DEPART_ID, user.getDepart_id())
      .set(USER.BIRTHDAY, new java.sql.Date(user.getBirthday().getTime()))
      .execute();
    return effectRow > 0;
  }

  //
//  public boolean doDelete(int id) throws Exception {
//    int effectRow = jooq.delete(USER)
//      .where(USER.ID.equal(id))
//      .execute();
//    return effectRow > 0;
//  }
  public boolean doDelete(int id, Configuration configuration) throws Exception {
    int effectRow = DSL.using(configuration).delete(USER)
      .where(USER.ID.equal(id))
      .execute();
    return effectRow > 0;

  }

//
//
//  public User findById(int id) throws Exception {
//    User user = jooq.selectFrom(USER)
//      .where(USER.ID.eq(id))
//      .fetchOne(userRecordMapper);
//    return user;
//  }


  public User findById(int id) throws Exception {
    User user = jooq.selectFrom(USER)
      .where(USER.ID.equal(id))
      .fetchOne(userRecordMapper);
    String sql = jooq.select(USER.NAME).from(USER).where(USER.ID.equal(1)).getSQL();

    return user;
  }
//
//  public boolean doUpdate(User user) throws Exception {
//    int effectRow = jooq.update(USER)
//      .set(USER.NAME, user.getName())
//      .set(USER.SEX, user.getName())
//      .set(USER.DEPART_ID, user.getDepart_id())
//      .set(USER.BIRTHDAY, new java.sql.Date(user.getBirthday().getTime()))
//      .where(USER.ID.eq(user.getId()))
//      .execute();
//    return effectRow > 0;
//  }


  public boolean doUpdate(User user, Configuration configuration) throws Exception {
    int effectRow = DSL.using(configuration).update(USER)
      .set(USER.NAME, user.getName())
      .set(USER.SEX, user.getSex())
      .set(USER.DEPART_ID, user.getDepart_id())
      .set(USER.BIRTHDAY, new java.sql.Date(user.getBirthday().getTime()))
      .where(USER.ID.eq(user.getId()))
      .execute();
    return effectRow > 0;
  }

  //
//  public List<User> findAll(String keyWord) throws Exception {
//    List<User> users = jooq.selectFrom(USER)
//      .where(USER.NAME.like(keyWord))
//      .or(USER.SEX.like(keyWord))
//      .or(USER.BIRTHDAY.like(keyWord))
//      .fetch(userRecordMapper);
//    return users;
//  }
  public List<User> findAll(String keyWord) throws Exception {
    List<User> users = jooq.selectFrom(USER)
      .where(USER.NAME.like(keyWord))
      .or(USER.SEX.like(keyWord))
      .or(USER.BIRTHDAY.like(keyWord))
      .fetch(userRecordMapper);
    return users;
  }


}

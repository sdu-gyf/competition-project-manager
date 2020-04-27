package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.model.GithubUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component(value = "githubMapper")
public interface GithubUserMapper {
    /**
     * 新建
     * @param record
     * @return
     */
    int insert(GithubUser record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(GithubUser record);

    /**
     * 根据id返回记录
     * @param accountId github返回的用户唯一id
     * @return
     */
    GithubUser selectByAccountId(@Param("account_id") Long accountId);
}
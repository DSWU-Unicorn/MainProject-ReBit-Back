package com.unicon.rebit.yongginae.userComment;

import com.unicon.rebit.yongginae.store.dto.StoreReviewsRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserCommentDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<StoreReviewsRes> selectReviews(Long store_id) {

        String selectReviewsQuery = "select star, comment_date, u.user_id, c.photo, comment_detail\n" +
                "FROM store s\n" +
                "LEFT OUTER JOIN user_comment c ON s.store_id = c.store_id\n" +
                "LEFT OUTER JOIN user u ON c.user_id = u.user_id\n" +
                "where s.store_id = ?";
        long selectReviewsParam = store_id;


        return this.jdbcTemplate.query(selectReviewsQuery,
                (rs, rowNum) -> new StoreReviewsRes(
                        rs.getLong("user_id"),
                        rs.getInt("star"),
                        rs.getTimestamp("comment_date").toLocalDateTime(),
                        rs.getString("photo"),
                        rs.getString("comment_detail")),
                selectReviewsParam);
    }

    public Long checkStoreIdExist(Long store_id) {
        String checkStoreIdQuery = "select exists(select store_id from user_comment where store_id = ?)";
        Long checkStoreIdParams = store_id;
        return this.jdbcTemplate.queryForObject(checkStoreIdQuery,
                Long.class,
                checkStoreIdParams);
    }

}
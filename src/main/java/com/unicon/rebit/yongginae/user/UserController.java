package com.unicon.rebit.yongginae.user;

import com.unicon.rebit.yongginae.configure.response.DataResponse;
import com.unicon.rebit.yongginae.configure.response.ResponseService;
import com.unicon.rebit.yongginae.user.dto.UserRes;
import com.unicon.rebit.yongginae.userComment.UserCommentRepository;
import com.unicon.rebit.yongginae.userComment.UserCommentService;
import com.unicon.rebit.yongginae.userComment.dto.UserCommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ResponseService responseService;

    // 코멘트 아이디 입력하면 댓글 내용 가져오기 - 진행 중
    /*
    @GetMapping("comment/{comment_id}")
    public DataResponse<List<UserRes>> getComment(@PathVariable("comment_id") Long id){
        List<UserRes> lists = userService.findComment(id);
        return responseService.getDataResponse(lists);
    }
    */

}

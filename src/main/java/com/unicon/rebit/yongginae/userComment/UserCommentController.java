package com.unicon.rebit.yongginae.userComment;

import com.unicon.rebit.yongginae.configure.response.DataResponse;
import com.unicon.rebit.yongginae.configure.response.ResponseService;
import com.unicon.rebit.yongginae.store.StoreService;
import com.unicon.rebit.yongginae.store.dto.StoreCategoryRes;
import com.unicon.rebit.yongginae.store.dto.StoreRes;
import com.unicon.rebit.yongginae.userComment.dto.UserCommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserCommentController {
    private final UserCommentService userCommentService;
    private final UserCommentRepository userCommentRepository;
    private final ResponseService responseService;

    @GetMapping("comment/user/{user_id}")
    public DataResponse<List<UserCommentRes>> getComment(@PathVariable("user_id") Long id){
        List<UserCommentRes> lists = userCommentService.findUserComment(id);
        return responseService.getDataResponse(lists);

    }

}

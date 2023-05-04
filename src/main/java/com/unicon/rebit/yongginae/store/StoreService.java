package com.unicon.rebit.yongginae.store;

import com.unicon.rebit.yongginae.configure.response.exception.CustomException;
import com.unicon.rebit.yongginae.configure.response.exception.CustomExceptionStatus;
import com.unicon.rebit.yongginae.review.ReviewSearchRes;
import com.unicon.rebit.yongginae.store.dto.*;
import com.unicon.rebit.yongginae.user.User;
import com.unicon.rebit.yongginae.user.UserRepository;
import com.unicon.rebit.yongginae.userComment.UserCommentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    private final UserCommentDao userCommentDao;

    public StoreRes findOne(Long storeId) {
        Store store = storeRepository.findOne(storeId);
        return new StoreRes(store.getStoreName(), store.getCategory1(), store.getCategory2(), store.getAddress(), store.getTel());
    }

    public List<StoreCategoryRes> findCategory(String category1, String category2) {
        List<Store> stores = storeRepository.findAddress(category1, category2);
        return stores.stream().map(StoreCategoryRes::new).collect(Collectors.toList());
    }

    public StoreAddressRes findAddress (Long storeId) {
        Store store = storeRepository.findOne(storeId);
        return new StoreAddressRes(store.getAddress());
    }

    public List<StoreAroundAddressRes> findAroundAddress(String search) {
        List<Store> stores = storeRepository.findAroundAddress(search);
        return stores.stream().map(StoreAroundAddressRes::new).collect(Collectors.toList());
    }

    public List<StoreSearchRes> findStore(String storeName) {
        List<Store> stores = storeRepository.findStore(storeName);
        return stores.stream().map(store -> new StoreSearchRes(store, store.getReview().stream().map(ReviewSearchRes::new).collect(Collectors.toList()))).collect(Collectors.toList());
    }

    public StoreSearchRes findStoreDetail(Long store_id) {
        Store store = storeRepository.findStoreDetail(store_id);
        return new StoreSearchRes(store, store.getReview().stream().map(ReviewSearchRes::new).collect(Collectors.toList()));
    }

    public List<StoreSearchNameRes> findStoreName(String storeName) {
        List<Store> stores = storeRepository.findStore(storeName);
        return stores.stream().map(store -> new StoreSearchNameRes(store.getStoreName(), store.getId())).collect(Collectors.toList());
    }

    @Transactional
    public int postUserWithPoint(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.ACCOUNT_NOT_FOUND));
        user.postPoint(300);
        return user.getPoint();
    }

    public List<StoreReviewsRes> findReviews(Long store_id) {
        try {
            List<StoreReviewsRes> reviewList = userCommentDao.selectReviews(store_id);
            return reviewList;
        } catch (NullPointerException exception) {
            exception.printStackTrace();
            throw new CustomException(CustomExceptionStatus.ACCOUNT_NOT_FOUND);
        }
    }

}

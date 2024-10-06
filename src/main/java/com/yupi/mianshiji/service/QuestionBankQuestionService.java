package com.yupi.mianshiji.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.mianshiji.model.dto.questionBankQuestion.QuestionBankQuestionQueryRequest;
import com.yupi.mianshiji.model.entity.QuestionBankQuestion;
import com.yupi.mianshiji.model.entity.User;
import com.yupi.mianshiji.model.vo.QuestionBankQuestionVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 题库服务
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://www.code-nav.cn">编程导航学习圈</a>
 */
public interface QuestionBankQuestionService extends IService<QuestionBankQuestion> {

    /**
     * 校验数据
     *
     * @param questionBankQuestion
     * @param add 对创建的数据进行校验
     */
    void validQuestionBankQuestion(QuestionBankQuestion questionBankQuestion, boolean add);

    /**
     * 获取查询条件
     *
     * @param questionBankQuestionQueryRequest
     * @return
     */
    QueryWrapper<QuestionBankQuestion> getQueryWrapper(QuestionBankQuestionQueryRequest questionBankQuestionQueryRequest);
    
    /**
     * 获取题库封装
     *
     * @param questionBankQuestion
     * @param request
     * @return
     */
    QuestionBankQuestionVO getQuestionBankQuestionVO(QuestionBankQuestion questionBankQuestion, HttpServletRequest request);

    /**
     * 分页获取题库封装
     *
     * @param questionBankQuestionPage
     * @param request
     * @return
     */
    Page<QuestionBankQuestionVO> getQuestionBankQuestionVOPage(Page<QuestionBankQuestion> questionBankQuestionPage, HttpServletRequest request);

    /**
     * 批量添加题目到题库
     * @param questionIdList
     * @param questionBankId
     * @param loginUser
     */
    void batchAddQuestionToBank(List<Long> questionIdList, long questionBankId, User loginUser);


    /**
     * 批量删除题目
     * @param questionIdList
     * @param questionBankId
     */
    void batchDeleteQuestionFromBank(List<Long> questionIdList, long questionBankId);

    void batchAddQuestionToBankInner(List<QuestionBankQuestion> questionBankQuestionList);
}

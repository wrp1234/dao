package com.wrp.wu.controller.support;

import com.wrp.wu.enums.SortedField;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author wrp
 * @date 2024年05月22日 7:52
 * @description
 */
@Data
public class ArticleQuery {

    @NotNull(message = "页码不能为空")
    private Long pageNo;
    @NotNull(message = "每页大小不能为空")
    @Max(value = 20, message = "页大小不能过大")
    @Min(value = 5, message = "页大小不能过小")
    private Long pageSize;
    private String value;
    private SortedField sortedBy;
}

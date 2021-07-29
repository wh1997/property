package com.tianjian.property.utils;

import com.tianjian.property.utils.error.BusinessException;
import com.tianjian.property.utils.error.ErrorEnum;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date on 2020\9\18 0018  15:32
 * @description 日期工具类
 */
@Slf4j
public class DateUtils {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Date stringToDate(String date) throws ParseException, BusinessException {
        return stringToDate(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * 将字符串转换为指定日期格式
     * @param date
     * @param formatType
     * @return
     * @throws ParseException
     * @throws BusinessException
     */
    public static Date stringToDate(String date, String formatType) throws ParseException, BusinessException {
        if(null == date || date.length() == 0){
            return null;
        }
        if(isDateString(date)){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatType);
            return simpleDateFormat.parse(date);
        }
        throw new BusinessException(ErrorEnum.OPERATION_ERROR, "日期格式不正确");
    }

    /**
     * 检测是否是默认日期格式
     * @param date
     * @return
     */
    public static boolean isDateString(String date) {
        return isDateString(date, DEFAULT_DATE_FORMAT);
    }

    /**
     * 检测是否是指定日期格式
     * @param date
     * @param formatType
     * @return
     */
    public static boolean isDateString(String date, String formatType) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatType);
        try {
            simpleDateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            log.error("日期格式不正确");
            return false;
        }
    }
}

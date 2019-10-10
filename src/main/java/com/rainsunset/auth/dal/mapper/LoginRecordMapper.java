package com.rainsunset.auth.dal.mapper;

import com.rainsunset.auth.dal.model.LoginRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Description: 登录记录表 Mapper
 * @Author: ligangwei
 * @Company rainsunset
 * @CreateDate: 2019-09-26 11:16:58
 * @Version : 1.0-SNAPSHOT
 */
@Repository
public interface LoginRecordMapper {

    /**
     * 依据条件查找 登录记录表 列表
     *
     * @param loginName
     * @param loginKey
     * @param loginType
     * @param systemType
     * @param systemVersion
     * @param accountStatus
     * @param safeStatus
     * @param ip
     * @param imsi
     * @param imei
     * @param locInfo
     * @param deviceId
     * @param createdAt
     * @param createdBy
     * @param updatedAt
     * @param updatedBy
     * @param validStatus
     * @return
     */
    public List<LoginRecord> selectLoginRecordList(@Param("uid") String uid,
		    @Param("loginName") String loginName, @Param("loginKey") String loginKey,
		    @Param("loginType") String loginType, @Param("systemType") String systemType,
		    @Param("systemVersion") String systemVersion, @Param("accountStatus") String accountStatus,
		    @Param("safeStatus") String safeStatus, @Param("ip") String ip,
		    @Param("imsi") String imsi, @Param("imei") String imei,
		    @Param("locInfo") String locInfo, @Param("deviceId") String deviceId,
		    @Param("createdAt") Date createdAt, @Param("createdBy") String createdBy,
		    @Param("updatedAt") Date updatedAt, @Param("updatedBy") String updatedBy,
		    @Param("validStatus") String validStatus
    );

    /**
     * 依据Id查找 登录记录表 详情
     *
     * @param id
     * @return
     */
    public LoginRecord getLoginRecordDetail(@Param("id") Integer id);

    /**
     * 全量插入 登录记录表
     *
     * @param loginRecord
     */
    public Integer fullInsertLoginRecord(LoginRecord loginRecord);

    /**
     * 依据主键更新 登录记录表
     *
     * @param loginRecord
     */
    public Integer updateLoginRecord(LoginRecord loginRecord);

    /**
     * 依据主键删除 登录记录表 记录
     *
     * @param ids
     * @param updatedBy
     */
    public Integer deleteLoginRecords(@Param("ids") Integer[] ids,
                                      @Param("updatedBy") String updatedBy);
}

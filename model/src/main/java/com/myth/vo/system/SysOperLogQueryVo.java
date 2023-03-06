package com.myth.vo.system;

import lombok.Data;

/**
 * @author may
 */
@Data
public class SysOperLogQueryVo {

	private String title;
	private String operName;

	private String createTimeBegin;
	private String createTimeEnd;

}


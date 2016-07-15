package com.lanhun.code;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/code")
public class CodeGenerator {

	private Logger logger = LogManager.getLogger(getClass());
	@Resource
	private com.lanhun.distributedSequence.CodeGenerator genertor;

	@RequestMapping("/generate")
	@ResponseBody
	public String generate() {
		long t=System.currentTimeMillis();
		String code=genertor.generate("O2O");
		t=System.currentTimeMillis()-t;
		logger.error("generate : "+code+" take "+t+" ms");
		return code;
	}
}

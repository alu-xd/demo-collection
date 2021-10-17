|CREATE TABLE student_score (
  id int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  name varchar(128) NOT NULL DEFAULT '' COMMENT '姓名',
  class_no varchar(128) NOT NULL DEFAULT '' COMMENT '班级',
  score int(10) NOT NULL DEFAULT '0' COMMENT '成绩',
  semester varchar(20) NOT NULL DEFAULT '' COMMENT '学期',
  created_date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  KEY idx_semester (semester)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='学生成绩表';
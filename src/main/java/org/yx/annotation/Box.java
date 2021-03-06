/**
 * Copyright (C) 2016 - 2030 youtongluan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.yx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.yx.db.DBType;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Box {
	public enum Transaction {
		/**
		 * 如果没有事务，就开启新事物。如果已经存在，就啥都不做
		 */
		NORMAL,

		/**
		 * 内嵌事务，相当于spring的NESTED
		 */
		EMBED,
		/**
		 * 没有事务
		 */
		NONE;
	}

	String dbName() default "sumk";

	DBType dbType() default DBType.ANY;

	Transaction transaction() default Transaction.NORMAL;
}

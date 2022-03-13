/*
 *	Copyright 2022 cufy.org
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	    http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package org.jamplate.jamc

import java.io.Serializable

/**
 * TODO
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
open class Module(
    /**
     * The qualifier (the uniq name) of this
     * module. (null for anonymous)
     *
     * Example: `com.example.my_module`
     *
     * @since 0.4.0 ~2022.03.12
     */
    val qualifier: String,
    /**
     * The source of this module.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val source: Source
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = -3253658711922482778L
    }
}

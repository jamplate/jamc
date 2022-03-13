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

import org.jamplate.jamtree.Tree
import java.io.Serializable

/**
 * A diagnostic message containing the details about an error, warning or even a note.
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
open class Message(
    /**
     * The message phrase.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val phrase: String? = null,
    /**
     * The priority constant.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val priority: String? = null,
    /**
     * The exception that caused the issue.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val exception: Throwable? = null,
    /**
     * The compilation where the error occurred.
     *
     * @since 0.4.0 ~2022.03.13
     */
    val compilation: Compilation? = null,
    /**
     * The module where the error occurred.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val module: Module? = null,
    /**
     * Critical points that have caused the error.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val trees: Set<Tree<*>> = emptySet()
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = -7833256408543201869L
    }
}

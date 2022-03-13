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

// Tree<Token> -> CharSequence

/**
 * A class holding the arguments of a formatter.
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
data class FormatterArgument(
    /**
     * The parent formatter.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val parent: Formatter,
    /**
     * The ambient compilation.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val compilation: Compilation,
    /**
     * The module.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val module: Module,
    /**
     * The tree to be formatted.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val tree: Tree<Token>
)

/**
 * A class holding the result of a formatter invocation.
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
data class FormatterResult(
    /**
     * The formatted text.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val sequence: CharSequence = "",
    /**
     * The messages from the formatter if any.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val messages: List<Message> = emptyList()
)

/**
 * A function that generates source-code from tokens.
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
fun interface Formatter {
    /**
     * Invoke this formatter.
     *
     * @param argument the formatter argument.
     * @throws Throwable
     * when an unexpected (fetal/internal) exception
     * occurs. And the processing must stop due to that.
     * @since 0.4.0 ~2022.03.12
     */
    operator fun invoke(argument: FormatterArgument): FormatterResult

    /**
     * A formatter that does nothing.
     *
     * @since 0.4.0 ~2022.03.12
     */
    companion object : Formatter {
        override fun invoke(argument: FormatterArgument): FormatterResult =
            FormatterResult()
    }
}

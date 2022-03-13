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

// Tree<Token> -> Mirror

/**
 * A class holding the arguments of a parser.
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
data class ParserArgument(
    /**
     * The parent parser.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val parent: Parser,
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
     * The tree to generate a mirror for.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val tree: Tree<Token>
)

/**
 * A class holding the result of a parser invocation.
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
data class ParserResult(
    /**
     * The output mirror.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val mirror: Mirror? = null,
    /**
     * The messages from the parser if any.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val messages: List<Message> = emptyList()
)

/**
 * A function that generates mirrors from tokens.
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
fun interface Parser {
    /**
     * Invoke this parser.
     *
     * @param argument the parser argument.
     * @throws Throwable
     * when an unexpected (fetal/internal) exception
     * occurs. And the processing must stop due to that.
     * @since 0.4.0 ~2022.03.12
     */
    operator fun invoke(argument: ParserArgument): ParserResult

    /**
     * A parser that does nothing.
     *
     * @since 0.4.0 ~2022.03.13
     */
    companion object : Parser {
        override fun invoke(argument: ParserArgument): ParserResult =
            ParserResult()
    }
}

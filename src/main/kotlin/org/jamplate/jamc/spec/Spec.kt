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

/**
 * TODO
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.13
 */
abstract class Spec(
    /**
     * The qualifier name of this spec.
     *
     * @since 0.4.0 ~2022.03.13
     */
    val qualifier: String
) : Iterable<Spec> {
    // Lexical

    /**
     * A lexer to be used at the lexical analysis
     * stage.
     *
     * @since 0.4.0 ~2022.03.13
     */
    // Tree<Token> -> Set<Tree<Token>>
    open val lexer: Lexer = Lexer

    /**
     * A formatter to be used when converting
     * tokens to source code.
     *
     * @since 0.4.0 ~2022.03.13
     */
    // Tree<Token> -> CharSequence
    open val formatter: Formatter = Formatter

    // IR

    /**
     * A parser to be used when transforming
     * tokens to mirrors (IR).
     */
    // Tree<Token> -> Mirror
    open val parser: Parser = Parser

    /**
     * A generator to be used when generating
     * tokens from mirrors (IR).
     *
     * @since 0.4.0 ~2022.03.13
     */
    // Mirror -> Tree<Token>
    open val generator: Generator = Generator

    // Translation

    /**
     * A translator to be used when generating
     * instructions from mirrors (IR).
     */
    // Mirror -> Instruction
    open val translator: Translator = Translator
}

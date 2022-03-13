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
 * @since 0.4.0 ~2022.03.12
 */
open class Compilation(
    /**
     * Reference modules.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val references: Set<Compilation> = emptySet(),
    /**
     * The modules in this compilation.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val modules: Set<Module> = emptySet(),
    /**
     * The execution options.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val options: Map<String, List<String>> = emptyMap(),
    /**
     * The execution flags.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val flags: List<String> = emptyList()
)

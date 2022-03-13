## *🚧🚧🚧 THIS PROJECT IS STILL UNDER DEVELOPMENT 🚧🚧🚧*

## Jamc

A general purpose compiler skeleton.

> This is a component of the compiler of the [jamplate](https://jamplate.org) programming language.

### 1 - Model

This section describes the terms and
components/classes.

#### 1.1 - Source

Wraps source code.

#### 1.2 - Module

Wraps a single file or component.

#### 1.3 - Token

Represents a single word/phrase

#### 1.4 - Mirror

Represents a component of the target language.

#### 1.5 - Instruction

Represents an instruction in the target language.

### 2 - Function

This section describes the kinds of functions to
be implemented.

#### 2.1 - Lexical Analysis

Lexing and formatting are the methods to convert
source-code to tokens and vice-versa.

##### 2.1.1 - Lexer

A lexer generate tokens from source-code.

##### 2.1.2 - Formatter

A formatter generates source-code from tokens.

#### 2.2 - Intermediate Representation

IR functions are the methods of generating mirrors
(IR) from tokens and vice-versa.

##### 2.2.1 - Parser

Generate mirrors from tokens

##### 2.2.2 - Generator

Generate tokens from mirrors

#### 2.3 - Translation

Translation stages are the methods of converting
mirrors into instructions and vice-versa.

##### 2.3.1 - Translator

Generate instructions from mirrors.

##### 2.3.2 - ????

Generate mirrors from instructions.

### 3 - Ambient

This section describes the objects representing
the processing context/environment.

#### 3.1 - Compilation

A compilation is a representation of a source set.

### 4 - Plugin System

This section describes the way of integrating with
the compiler.

#### 4.1 Spec

A container of set of workers to achieve a
feature.

### 5 - Diagnostic

This section describes the diagnostic method.

#### 5.1 - Message

A message is an invocation output sent by one of
the functions described in section `2` to indicate
an issue in the input.

Issues in the logic of the compiler itself is not
reporting this way. Instead, it is reported by
throwing the error and catching it at an earlier
stage of the compiler.

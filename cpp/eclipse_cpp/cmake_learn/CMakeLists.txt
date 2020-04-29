cmake_minimum_required(VERSION 2.6)

project(cmake_learn)

message(STATUS "This is BINARY dir [${cmake_learn_BINARY_DIR}]")
message(STATUS "This is SOURCE dir [${cmake_learn_SOURCE_DIR}]")

set(EXECUTABLE_OUTPUT_PATH ${cmake_learn_SOURCE_DIR}/bin)
set(LIBRARY_OUTPUT_PATH ${cmake_learn_SOURCE_DIR}/lib)

set(FILE_LIST
	cmake_learn.cpp
)

set(CMAKE_INSTALL_PREFIX 

add_subdirectory(src bin)
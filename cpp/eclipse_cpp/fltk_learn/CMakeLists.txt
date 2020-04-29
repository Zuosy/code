
cmake_minimum_required(VERSION 2.6)

# config
set(CMAKE_C_COMPILER "/usr/bin/clang")
set(CMAKE_CXX_COMPILER "/usr/bin/clang++")

message(STATUS "CMAKE_C_COMPILER    [${CMAKE_C_COMPILER}]")
message(STATUS "CMAKE_CXX_COMPILER  [${CMAKE_CXX_COMPILER}]")

set(project_name "fltk_learn")
project(${project_name})

include_directories(
	/usr/local/include
	/usr/include/freetype2
	/usr/include/libpng16
)

link_directories(
	/usr/local/lib
)

set(file_list
    "fltk_learn.cpp")
    
add_definitions(-D_LARGEFILE_SOURCE)
add_definitions(-D_LARGEFILE64_SOURCE)
add_definitions(-D_THREAD_SAFE)
add_definitions(-D_REENTRANT)

add_executable(main ${file_list})

target_link_libraries(main
	-lXrender
	-lXcursor
	-lXfixes
	-lXext
	-lXft
	-lfontconfig
	-lXinerama
	-lpthread
	-ldl
	-lm
	-lX11
)



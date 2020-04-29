message(STATUS "===================华丽的分割线===================")
message(STATUS "需要编译的文件")
message(STATUS ${FILE_LIST})
message(STATUS "===================华丽的分割线===================")

add_executable(main ${FILE_LIST})


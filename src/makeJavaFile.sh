#!/bin/bash
$temp="$1.java"
echo temp;
touch collection/$temp
echo "package collection;" >> collection/$temp
echo "public class $temp {}" >> collection/$temp
echo "File generated"

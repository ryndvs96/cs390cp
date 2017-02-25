#!/bin/bash

javac *.java

# does the actual testing
test() {
  if [ -z $1 ]
  then
    return 1
  fi

  if [ -f in${1} ] && [ -f out${1} ]
  then
    echo "Test #$1 ..."
    cat in${1} | java Solution > myout${1}
    cmp out${1} myout${1}
    if [ $? -gt 0 ]
    then
      echo 'Failed!!!'
    else
      echo 'Passed!'
    fi
    return 0
  else
    return 1
  fi
}

if [ ! -z $1 ]
then
  test $1
else
  # do a max of 100 tests
  for (( i=0; i < 100; i++ ))
  do
    test ${i}
    if [ $? -gt 0 ]
    then
      # break if no longer valid tests
      break
    fi
  done
fi



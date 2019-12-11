# Kotlin Demo

A kotlin demo for [Advent of Code 2018, Day 7](https://adventofcode.com/2018/day/7)

## Problem

Given instructions that specify a series of steps and requirements about which steps must be finished before others can begin, 
determine the order in which the steps should be completed. If more than one step is ready, choose the step which is first alphabetically.

### Example

The following instructions:
```
Step C must be finished before step A can begin.
Step C must be finished before step F can begin.
Step A must be finished before step B can begin.
Step A must be finished before step D can begin.
Step B must be finished before step E can begin.
Step D must be finished before step E can begin.
Step F must be finished before step E can begin.
```

Can be visually represented like this: 
```
  -->A--->B--
 /    \      \
C      -->D----->E
 \           /
  ---->F-----
```

The correct step order is `CABDFE`
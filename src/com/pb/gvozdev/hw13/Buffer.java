package com.pb.gvozdev.hw13;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Buffer {

     final List<Integer> buffer = new LinkedList<>();

}

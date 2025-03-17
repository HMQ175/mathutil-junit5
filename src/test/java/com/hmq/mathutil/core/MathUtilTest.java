package com.hmq.mathutil.core;
// import static là dành riêng cho những hàm static
// gọi hàm mà bỏ qua tên class

import static com.hmq.mathutil.core.MathUtil.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.MethodSources;

public class MathUtilTest {

	// chơi DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này vào trong câu lệnh kiểm thử
	// chuẩn bị bộ data
	public static Object[][] initData() {
		return new Integer[][] {
									{1,1},
									{2,2},
									{5,520},
									{6,720},
								};
	}
	
	@ParameterizedTest
	@MethodSource(value = "initData") // tên hàm cung cấp data, ngầm định thứ tự
	// của các phần tử mảng, map vào tham số hàm
	public void testGetFactorialGivenRightArgReturnsWell(int input, long expected) {
		assertEquals(expected, getFactorial(input));
	}
//	@Test
//	public void testGetFactorialGivenRightArgReturnsWell() {
//		assertEquals(24,getFactorial(4));
//	}
	// bắt ngoại lệ khi đưa data cà chớn!!!
	// @Test (expected = tên ngoại lệ .class) JUnit hoy, JUnit hok xài vậy!!!

	@Test
	public void testGetFactorialGivenWrongArgThrowException() {
		// xài biểu thức lambda
		// hàm nhận tham số thứ 2 là 1 cái object/có code implement cái
		// functional interface tên là Executable - có 1 hàm duy nhất không code
		// tên là execute()
		// chơi chậm
//		Executable exObject = new Executable() {
//			@Override
//			public void execute() throws Throwable {
//				getFactorial(-5);
//			}
//		};
		assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
	}
}

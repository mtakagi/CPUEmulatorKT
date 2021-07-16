package cpuemulator

enum class OpCode(val code: Short) {
    MOV(0),
    ADD(1),
    SUB(2),
    AND(3),
    OR(4),
    SL(5),
    SR(6),
    SRA(7),
    LDL(8),
    LDH(9),
    CMP(10),
    JE(11),
    JMP(12),
    LD(13),
    ST(14),
    HLT(15),
    NOP(-1);

    companion object {
        fun toOpCode(code: Short) : OpCode {
            return when(code) {
                0.toShort() -> MOV
                1.toShort() -> ADD
                2.toShort() -> SUB
                3.toShort() -> AND
                4.toShort() -> OR
                5.toShort() -> SL
                6.toShort() -> SR
                7.toShort() -> SRA
                8.toShort() -> LDL
                9.toShort() -> LDH
                10.toShort() -> CMP
                11.toShort() -> JE
                12.toShort() -> JMP
                13.toShort() -> LD
                14.toShort() -> ST
                15.toShort() -> HLT
                else -> NOP
            }
        }
    }
}


infix fun OpCode.shl(value: Short) : Short = (this.code.toInt() shl value.toInt()).toShort()
infix fun OpCode.and(value: Short) : Short = (this.code.toInt() and value.toInt()).toShort()
infix fun OpCode.or(value: Short) : Short = (this.code.toInt() or value.toInt()).toShort()
operator fun Array<Short>.get(index: Short): Short = get(index.toInt())
infix fun Short.shl(value: Short) : Short = (this.toInt() shl value.toInt()).toShort()
infix fun Short.ushr(value: Short) : Short = (this.toInt() ushr value.toInt()).toShort()
infix fun Short.and(value: Short) : Short = (this.toInt() and value.toInt()).toShort()
infix fun Short.or(value: Short) : Short = (this.toInt() or value.toInt()).toShort()
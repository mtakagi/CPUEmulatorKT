package cpuemulator

object Operation {
    fun mov(ra: Short, rb: Short) : Short = ((OpCode.MOV.code shl 11) or (ra shl 8) or (rb shl 5))
    fun add(ra: Short, rb: Short) : Short = ((OpCode.ADD.code shl 11) or (ra shl 8) or (rb shl 5))
    fun sub(ra: Short, rb: Short) : Short = ((OpCode.SUB.code shl 11) or (ra shl 8) or (rb shl 5))
    fun and(ra: Short, rb: Short) : Short = ((OpCode.AND.code shl 11) or (ra shl 8) or (rb shl 5))
    fun or(ra: Short, rb: Short) : Short = ((OpCode.OR.code shl 11) or (ra shl 8) or (rb shl 5))
    fun sl(ra: Short) : Short = ((OpCode.SL.code shl 11) or (ra shl 8))
    fun sr(ra: Short) : Short = ((OpCode.SR.code shl 11) or (ra shl 8))
    fun sra(ra: Short) : Short = ((OpCode.SRA.code shl 11) or (ra shl 8))
    fun ldl(ra: Short, ival: Short) : Short = ((OpCode.LDL.code shl 11) or (ra shl 8) or (ival and 0x00ff))
    fun ldh(ra: Short, ival: Short) : Short = ((OpCode.LDH.code shl 11) or (ra shl 8) or (ival and 0x00ff))
    fun cmp(ra: Short, rb: Short) : Short = ((OpCode.CMP.code shl 11) or (ra shl 8) or (rb shl 5))
    fun je(addr: Short) : Short = ((OpCode.JE.code shl 11) or (addr and 0x00ff))
    fun jmp(addr: Short) : Short = ((OpCode.JMP.code shl 11) or (addr and 0x00ff))
    fun ld(ra: Short, addr: Short) : Short = ((OpCode.LD.code shl 11) or (ra shl 8) or (addr and 0x00ff))
    fun st(ra: Short, addr: Short) : Short = ((OpCode.ST.code shl 11) or (ra shl 8) or (addr and 0x00ff))
    fun hlt() : Short = OpCode.HLT shl 11

    fun code(ir: Short) : OpCode = OpCode.toOpCode(ir ushr 11)
    fun regA(ir: Short) : Short = (ir ushr 8) and 0x0007
    fun regB(ir: Short) : Short = (ir ushr 5) and 0x0007
    fun data(ir: Short) : Short = (ir and 0x00ff)
    fun addr(ir: Short) : Short = (ir and 0x00ff)
}

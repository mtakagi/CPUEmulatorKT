import cpuemulator.*

fun main() {
    var pc : Short = 0
    var ir : Short
    var flagEq : Short = 0
    val rom = Rom(256) { 0 }
    val ram = Ram(256) { 0 }
    val reg = Array<Short>(256) { 0 }

    Assembler().assemble(rom)

    do {
        ir = rom[pc.toInt()]
        println("$pc $ir ${reg[0]} ${reg[1]} ${reg[2]} ${reg[3]}")
        pc = (pc + 1).toShort()

        when (Operation.code(ir)) {
            OpCode.MOV -> reg[Operation.regA(ir).toInt()] = reg[Operation.regB(ir).toInt()]
            OpCode.ADD -> reg[Operation.regA(ir).toInt()] = (reg[Operation.regA(ir).toInt()] + reg[Operation.regB(ir).toInt()]).toShort()
            OpCode.SUB -> reg[Operation.regA(ir).toInt()] = (reg[Operation.regA(ir).toInt()] - reg[Operation.regB(ir).toInt()]).toShort()
            OpCode.AND -> reg[Operation.regA(ir).toInt()] = (reg[Operation.regA(ir).toInt()] and reg[Operation.regB(ir).toInt()])
            OpCode.OR -> reg[Operation.regA(ir).toInt()] = (reg[Operation.regA(ir).toInt()] or reg[Operation.regB(ir).toInt()])
            OpCode.SL -> reg[Operation.regA(ir).toInt()] = reg[Operation.regA(ir).toInt()] shl 1
            OpCode.SR -> reg[Operation.regA(ir).toInt()] = reg[Operation.regA(ir).toInt()] ushr 1
            OpCode.SRA -> reg[Operation.regA(ir).toInt()] = (reg[Operation.regA(ir).toInt()] and 0x8000.toShort()) or (reg[Operation.regA(ir).toInt()] ushr  1)
            OpCode.LDL -> reg[Operation.regA(ir).toInt()] = (reg[Operation.regA(ir).toInt()] and 0xff00.toShort()) or (Operation.data(ir) and 0x00ff)
            OpCode.LDH-> reg[Operation.regA(ir).toInt()] = (Operation.data(ir) shl 8) or (reg[Operation.regA(ir).toInt()] and 0x00ff)
            OpCode.CMP -> flagEq = if (reg[Operation.regA(ir).toInt()] == reg[Operation.regB(ir).toInt()]) 1 else 0
            OpCode.JE -> if (flagEq == 1.toShort()) { pc = Operation.addr(ir) }
            OpCode.JMP -> pc = Operation.addr(ir)
            OpCode.LD -> reg[Operation.regA(ir).toInt()] = ram[Operation.addr(ir).toInt()]
            OpCode.ST -> ram[Operation.addr(ir).toInt()] = reg[Operation.regA(ir).toInt()]
            else -> Unit
        }

    } while(Operation.code(ir) != OpCode.HLT)

    println("ram[64] = ${ram[64]}")
}
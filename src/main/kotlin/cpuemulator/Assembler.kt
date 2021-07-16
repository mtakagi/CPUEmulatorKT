package cpuemulator

class Assembler {
    fun assemble(rom: Rom)
    {
        rom[0] = Operation.ldh(Register.REG0.number, 0)
        rom[1] = Operation.ldl(Register.REG0.number, 0)
        rom[2] = Operation.ldh(Register.REG1.number, 0)
        rom[3] = Operation.ldl(Register.REG1.number, 1)
        rom[4] = Operation.ldh(Register.REG2.number, 0)
        rom[5] = Operation.ldl(Register.REG2.number, 0)
        rom[6] = Operation.ldh(Register.REG3.number, 0)
        rom[7] = Operation.ldl(Register.REG3.number, 10)
        rom[8] = Operation.add(Register.REG2.number, Register.REG1.number)
        rom[9] = Operation.add(Register.REG0.number, Register.REG2.number)
        rom[10] = Operation.st(Register.REG0.number, 64)
        rom[11] = Operation.cmp(Register.REG2.number, Register.REG3.number)
        rom[12] = Operation.je(14)
        rom[13] = Operation.jmp(8)
        rom[14] = Operation.hlt()
    }
}